import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class App {

    public static void readFromWeb(String webURL) throws IOException {
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("<div>")|| line.contains("</div>>") ){
                    System.out.println(line);
                }
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

    }

    public static void input() {
        

    }
    public static void main(String[] args) throws IOException {

        String career = "software-engineer";
        String url = "https://www.glassdoor.com/";
        /* parsing e.g*/
        String base = "https://www.indeed.com/career/" + career.toString() +"/salaries";
        readFromWeb(url);
    }

}
