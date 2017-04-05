package actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SolrControl {
	
	public static void actualizarIndices() {
		try{
			getUrlSource("http://localhost:8983/solr/productos/dataimport?command=full-import");
			//getUrlSource("http://localhost:8983/solr/productos/dataimport?command=full-import");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	@SuppressWarnings("deprecation")
	public static String obtenerJson(String palabrasClave) throws IOException{
		return getUrlSource("http://localhost:8983/solr/productos/select?q="+URLEncoder.encode(palabrasClave)+"&wt=json&qf=nombre_name&qf=descripcionCorta_name&qf=descripcionLarga_name&defType=edismax&omitHeader=true");
		
	}
	/**
	 *  
	 * @param url
	 * @return
	 * @throws IOException
	 */
	 private static String getUrlSource(String url) throws IOException {
         URL yahoo = new URL(url);
         URLConnection yc = yahoo.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(
                 yc.getInputStream(), "UTF-8"));
         String inputLine;
         StringBuilder a = new StringBuilder();
         while ((inputLine = in.readLine()) != null)
             a.append(inputLine);
         in.close();

         return a.toString();
     }
}
