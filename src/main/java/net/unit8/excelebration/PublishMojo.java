package net.unit8.excelebration;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Keyword;
import clojure.lang.PersistentHashMap;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * @author kawasima
 */
@Mojo(name = "publish")
public class PublishMojo extends AbstractMojo {
    /** Input file */
    @Parameter(required = true)
    protected File input;

    /** Output file */
    @Parameter(required = true)
    protected File output;

    /** Output format */
    @Parameter(defaultValue = "excel")
    protected String format;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Clojure.var("clojure.core/require")
                .invoke(Clojure.read("excelebration.publish"));
        PersistentHashMap options = PersistentHashMap.create();
        IFn publishFunc = Clojure.var("excelebration.publish", "publish");
        publishFunc.invoke(input.getPath(), output.getPath(),
                Keyword.find(format),
                options);
    }
}
