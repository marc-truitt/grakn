/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016-2018 Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/agpl.txt>.
 */

package ai.grakn.bootup.graknengine.pid;

import java.nio.file.Path;

/**
 *
 * A class responsible for instantiating GraknPidManager
 *
 * @author Ganeshwara Herawan Hananda
 *
 */
public class GraknPidManagerFactory {

    private GraknPidManagerFactory(){}

    /*
     * instantiates a GraknPidManager which supports *nix systems such as Linux and OS X
     */
    public static GraknPidManager newGraknPidManagerForUnixOS(Path pidfilePath) {
        GraknPidStore graknPidStore = new GraknPidFileStore(pidfilePath);
        GraknPidRetriever graknPidRetriever = new UnixGraknPidRetriever();
        return new GraknPidManager(graknPidStore, graknPidRetriever);
    }
}
