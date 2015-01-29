package net.unit8.excelebration;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

/**
 * @author kawasima
 */
public class PublishMojoTest {
    @Test
    public void test() throws URISyntaxException, MojoFailureException, MojoExecutionException {
        PublishMojo mojo = new PublishMojo();
        mojo.input = new File(Thread.currentThread().getContextClassLoader()
                .getResource("test.md").toURI());
        mojo.output = new File("target/output.xlsx");
        mojo.format = "excel";
        mojo.execute();
    }

    @Test
    public void genWithTemplate() throws URISyntaxException, MojoFailureException, MojoExecutionException {
        PublishMojo mojo = new PublishMojo();
        mojo.input = new File(Thread.currentThread().getContextClassLoader()
                .getResource("test.md").toURI());
        mojo.output = new File("target/output.xlsx");
        mojo.format = "excel";
        mojo.template = new File(Thread.currentThread().getContextClassLoader()
                .getResource("template.clj").toURI());
        mojo.execute();
    }

}
