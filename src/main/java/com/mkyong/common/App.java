package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.bo.AssetsBo;
import com.mkyong.stock.model.Assets;
import com.mkyong.stock.bo.HistoricalPricesBo;
import com.mkyong.stock.model.HistoricalPrices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

public class App
{
  static ApplicationContext appContext =	new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

    public static Date StringToDate(String sDateFormat, String sDate ) throws Exception
    {
      Date returnDate;
      String sDateError  = "Jan 1, 1700";
/*    date  "31/12/1998",  "31-Dec-1998", "12 31, 1998", "Thu, Dec 31 1998";
                          "Thu, Dec 31 1998 23:37:50", "31-Dec-1998 23:37:50","Aug 23, 2019"
  date format examples "dd/MM/yyyy", "yyyy-MM-dd", "MM dd, yyyy", "E, MMM dd yyyy", "E, MMM dd yyyy HH:mm:ss", "dd-MMM-yyyy HH:mm:ss"*/
      SimpleDateFormat formatter=new SimpleDateFormat(sDateFormat);
      try
      {
        returnDate=formatter.parse(sDate);

      }
      catch (Exception ex)
      {
        returnDate=formatter.parse(sDateError);
      }
      return(returnDate);

    }


    public static void main( String[] args )
    {
      AssetsBo assetsBo = (AssetsBo)appContext.getBean("assetsBo");
//      Assets assets = new Assets();

      Assets stock2 = assetsBo.findByStockId("3");
      System.out.println(stock2);

      List <?> stockRows = assetsBo.findByType("Stock");

      for (int x = 0; x < stockRows.size(); x++)
      {
        Assets stock = (Assets) stockRows.get(x);
        System.out.println("Name: " + stock.getName() + ",  Symbol: " + stock.getSymbol() + ", Type: " + stock.getType());
        addYahooStockHistoryToHistoricalPrices(stock.getSymbol() );
      }
/*      assets.setName("stockSymbol");
      assets.setSymbol("JJJOOOO");
      try
      {
        assetsBo.save(assets);
      }

      catch (org.springframework.dao.DataIntegrityViolationException ex)
      {
        System.out.println("DataIntegrityViolationException Exception!!");
        System.out.println(ex);
      }
      catch (HibernateException ex)
      {
        System.out.println("Hibernate Exception!!");
        System.out.println(ex);
      }
      catch (Exception ex)
      {
        System.out.println("Exception Exception!!");
        System.out.println(ex);
      }*/

  //    addYahooStockHistoryToHistoricalPrices("PEGA"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day

    }

    public static void addYahooStockHistoryToHistoricalPrices( String stockSymbol )
    {
      String urlQuoteHistory ="https://finance.yahoo.com/quote/" + stockSymbol + "/history";

      String HTMLSTring  = getUrlContents(urlQuoteHistory);
    //  String HTMLSTring  = getUrlContents("https://finance.yahoo.com/quote/AIG/history?p=AIG");
      Document doc = Jsoup.parse(HTMLSTring);
      String title = doc.title();
      System.out.printf("Title: %s%n", title);
    	Element table = doc.select("table").get(0); //select the first table.
    	Elements rows = table.select("tr");
      List<String[]> rowsString = new ArrayList<String[]>();
      rowsString = HTMLElementsToListString(rows);
      addStockToHistoricalPrices(stockSymbol,rowsString, "MMM dd, yyyy"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
     }

    public static void addCSVFilesToHistoricalPrices( )
    {
      List<String[]> rowsString = new ArrayList<String[]>();

      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/AAPL.csv");
      addStockToHistoricalPrices("AAPL",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/ADBE.csv");
      addStockToHistoricalPrices("ADBE",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/AXP.csv");
      addStockToHistoricalPrices("AXP",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/CAT.csv");
      addStockToHistoricalPrices("CAT",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/CLDR.csv");
      addStockToHistoricalPrices("CLDR",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/COF.csv");
      addStockToHistoricalPrices("COF",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/CPWR.csv");
      addStockToHistoricalPrices("CPWR",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/F.csv");
      addStockToHistoricalPrices("F",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/GBTC.csv");
      addStockToHistoricalPrices("GBTC",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/GE.csv");
      addStockToHistoricalPrices("GE",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/SBUX.csv");
      addStockToHistoricalPrices("SBUX",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/SIRI.csv");
      addStockToHistoricalPrices("SIRI",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day
      rowsString = parseCSV("/home/jdellaria/Desktop/HistoricalPrices/STI.csv");
      addStockToHistoricalPrices("STI",rowsString, "yyyy-MM-dd"); // Lowercase y is Year-  Upper case M is Month - Lowercase d is Day

/*      for (int x = 0; x < rowsString.size(); x++)
       {
         String[] column = rowsString.get(x);
         try
         {
           System.out.println("AIG [date= " + column[0] + ",  dFormat= " + StringToDate( "yyyy-mm-dd", column[0]) + ", Open=" + column[1] +  " , High=" + column[2] +  " , Low=" + column[3] +  " , Close=" + column[4] + " , AdjClose=" + column[5] + " , Volume=" + column[6] +   "]");
         }
         catch (Exception ex)
           {
             System.out.println("Date Exception!!");
           }
       }*/
     }

     public static void addStockToHistoricalPrices(String stockSymbol, List<String[]> rows, String dateFormat)
     {
//       System.out.println("!!!!!!!!!!!!!!!!! Entering Application for HIBERNATE Stock !!!!!!!!!!!!!!!!!!!");
//        ApplicationContext appContext =	new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
        //       System.out.println("!!!!!!!!!!!!!!!!! appContext!!!!!!!!!!!!!!!!! ");

        HistoricalPricesBo historicalPricesBo = (HistoricalPricesBo)appContext.getBean("historicalPricesBo");
        HistoricalPrices historicalPrices = new HistoricalPrices();

       for (int i = 0; i < rows.size(); i++)
       {
          String[] column = rows.get(i);
//          System.out.printf("Date: %s Open: %s High: %s Low: %s Close: %s AdjClose: %s  Volume: %s \n", column[0], column[1], column[2], column[3], column[4], column[5], column[6]);

          historicalPrices.setSymbol(stockSymbol);
          historicalPrices.setTimeStamp(column[0]);
          try
          {
            historicalPrices.setDateStamp(StringToDate(dateFormat, column[0]));
          }
          catch (Exception ex)
          {
            System.out.println("Date Exception!!");
          }
          historicalPrices.setOpen(Double.parseDouble(column[1].replaceAll(",", "")));
          historicalPrices.setHigh(Double.parseDouble(column[2].replaceAll(",", "")));
          historicalPrices.setLow(Double.parseDouble(column[3].replaceAll(",", "")));
          historicalPrices.setClose(Double.parseDouble(column[4].replaceAll(",", "")));
          historicalPrices.setAdjClose(Double.parseDouble(column[5].replaceAll(",", "")));
          historicalPrices.setVolume(Integer.parseInt(column[6].replaceAll(",", "")));
          try
          {
            historicalPricesBo.save(historicalPrices);
          }

          catch (org.springframework.dao.DataIntegrityViolationException ex)
          {
            System.out.println("DataIntegrityViolationException Exception!!");
            System.out.println(ex);
          }
          catch (HibernateException ex)
          {
            System.out.println("Hibernate Exception!!");
            System.out.println(ex);
          }
          catch (Exception ex)
          {
            System.out.println("Exception Exception!!");
            System.out.println(ex);
          }
      }
    }


  //        	    if (cols.get(7).text().equals("down")) {
  //      downServers.add(cols.get(5).text());
  //    }

    public static List<String[]> HTMLElementsToListString(Elements rows)
	    {
	      List<String[]> listStrings = new ArrayList<String[]>();

	      for (int i = 0; i < rows.size(); i++)
	      { //first row is the col names so skip it.
	    	ArrayList<String> rowStrings= new ArrayList<String>();
	        Element row = rows.get(i);
	        Elements cols = row.select("td");
//	        System.out.println("HTMLElementsToListString Column size: " + cols.size());
	        if (cols.size() > 3)
	        {
	        	String[] stringArray = {
	    			cols.get(0).text(),
	    			cols.get(1).text(),
	    			cols.get(2).text(),
	    			cols.get(3).text(),
	    			cols.get(4).text(),
	    			cols.get(5).text(),
	    			cols.get(6).text()
	    			};
	          listStrings.add(stringArray);
	        }
	      }
	      return(listStrings);

	    }


    	/** select **/
//    	Stock stock2 = stockBo.findByStockCode("7668");
//    	System.out.println(stock2);

    	/** update **/
//    	stock2.setStockName("HAIO-1");
//    	stockBo.update(stock2);

    	/** delete **/
//    	stockBo.delete(stock2);

//    	System.out.println("Done");
//    }



    public static List<String[]> parseCSV(String csvFile ){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> row = new ArrayList<String[]>();

        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {

                // use comma as separator
                String[] column = line.split(cvsSplitBy);
                if (column[1].contains("null"))
                {
                	column[1] = "0"; //is string is null set to 0
                	 System.out.println(" 1 null detected");

                }
                if (column[2].contains("null"))
                {
                	column[2] = "0"; //is string is null set to 0
                	 System.out.println(" 2 null detected");

                }
                if (column[3].contains("null"))
                {
                	column[3] = "0"; //is string is null set to 0
                	 System.out.println(" 3 null detected");

                }
                if (column[4].contains("null"))
                {
                	column[4] = "0"; //is string is null set to 0
                	 System.out.println(" 4 null detected");

                }
                if (column[5].contains("null"))
                {
                	column[5] = "0"; //is string is null set to 0
                	 System.out.println(" 5 null detected");

                }
                if (column[6].contains("null"))
                {
                	column[6] = "0"; //is string is null set to 0\             	 System.out.println(" 1 null detected");
                	 System.out.println(" 6 null detected");

                }
                row.add(column);
           }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return(row);
    }

  private static String getUrlContents(String theUrl)
  {
    StringBuilder content = new StringBuilder();

    // many of these calls can throw exceptions, so i've just
    // wrapped them all in one try/catch statement.
    try
    {
      // create a url object
      URL url = new URL(theUrl);

      // create a urlconnection object
      URLConnection urlConnection = url.openConnection();

      // wrap the urlconnection in a bufferedreader
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

      String line;

      // read from the urlconnection via the bufferedreader
      while ((line = bufferedReader.readLine()) != null)
      {
        content.append(line + "\n");
      }
      bufferedReader.close();
      }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return content.toString();
  }
}
