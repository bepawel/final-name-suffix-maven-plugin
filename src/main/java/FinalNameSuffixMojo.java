import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Sets finalName.suffix property.
 *
 * When version contains SNAPSHOT, suffix is a timestamp, otherwise empty string.
 */
@Mojo(name="setFinalName")
public class FinalNameSuffixMojo extends AbstractMojo {

    @Parameter( defaultValue = "${project}", readonly = true, required = true )
    private MavenProject project;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public void execute() throws MojoExecutionException, MojoFailureException {

        Timestamp buildTimestamp = new Timestamp(System.currentTimeMillis());
        String finalNameSuffix = "";

        if(project.getVersion().contains("SNAPSHOT")) {
            finalNameSuffix = sdf.format(buildTimestamp);
        }

        project.getProperties().put("finalName.suffix", finalNameSuffix);

    }
}
