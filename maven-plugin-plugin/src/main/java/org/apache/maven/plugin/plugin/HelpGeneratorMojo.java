package org.apache.maven.plugin.plugin;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.tools.plugin.generator.Generator;
import org.apache.maven.tools.plugin.generator.PluginHelpGenerator;

/**
 * Generates an <code>HelpMojo</code> class.
 *
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @version $Id$
 * @since 2.4
 * @goal helpmojo
 * @phase generate-sources
 */
public class HelpGeneratorMojo
    extends AbstractGeneratorMojo
{
    /**
     * The directory where the generated <code>HelpMojo</code> file will be put.
     *
     * @parameter default-value="${project.build.directory}/generated-sources/plugin"
     */
    protected File outputDirectory;

    /** {@inheritDoc} */
    protected File getOutputDirectory()
    {
        return outputDirectory;
    }

    /** {@inheritDoc} */
    protected Generator createGenerator()
    {
        return new PluginHelpGenerator();
    }

    /** {@inheritDoc} */
    public void execute()
        throws MojoExecutionException
    {
        super.execute();

        if ( !project.getCompileSourceRoots().contains( outputDirectory.getAbsolutePath() ) )
        {
            project.addCompileSourceRoot( outputDirectory.getAbsolutePath() );
        }
    }
}
