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
import java.util.HashMap;
import java.util.Map;

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

    /** template file */
    @Parameter(name = "template")
    protected File template;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Clojure.var("clojure.core/require")
                .invoke(Clojure.read("excelebration.publish"));
        Map<Keyword, Object> options = new HashMap<Keyword, Object>();
        if (template != null && template.isFile()) {
            options.put(Keyword.find("template"), template.getPath());
        }
        IFn publishFunc = Clojure.var("excelebration.publish", "publish");
        publishFunc.invoke(input.getPath(), output.getPath(),
                Keyword.find(format),
                PersistentHashMap.create(options));
    }
}
