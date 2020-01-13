package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App
{
    public static void main( String[] args )
    {
      System.out.println("!!!!!!!!!!!!!!!!! Entering Application for HIBERNATE Stock !!!!!!!!!!!!!!!!!!!");
    	ApplicationContext appContext =	new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
      System.out.println("!!!!!!!!!!!!!!!!! appContext!!!!!!!!!!!!!!!!! ");

    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
      Stock stock = new Stock();

      String HTMLSTring  = getUrlContents("https://finance.yahoo.com/quote/AIG/history?p=AIG");
      Document doc = Jsoup.parse(HTMLSTring);
      String title = doc.title();
      System.out.printf("Title: %s%n", title);
//    	Element link = doc.select("table").first();
    	Element table = doc.select("table").get(0); //select the first table.
    	Elements rows = table.select("tr");
      for (int i = 1; i < rows.size(); i++)
      { //first row is the col names so skip it.
        Element row = rows.get(i);
        Elements cols = row.select("td");
        if (cols.size() > 3)
        {
              	/** insert **/
              	stock.setSymbol("AIG");
              	stock.setTimeStamp(cols.get(0).text());
                stock.setOpen(Double.parseDouble(cols.get(1).text()));
                stock.setHigh(Double.parseDouble(cols.get(2).text()));
                stock.setLow(Double.parseDouble(cols.get(3).text()));
                stock.setClose(Double.parseDouble(cols.get(4).text()));
                stock.setAdjClose(Double.parseDouble(cols.get(5).text()));
                try
                {
                  stockBo.save(stock);
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
          System.out.printf("Date: %s Open: %s High: %s Low: %s Close: %s AdjClose: %s %n", cols.get(0).text(), cols.get(1).text(), cols.get(2).text(), cols.get(3).text(), cols.get(4).text(), cols.get(5).text());
        }
  //        	    if (cols.get(7).text().equals("down")) {
  //      downServers.add(cols.get(5).text());
  //    }
    }



    	/** select **/
//    	Stock stock2 = stockBo.findByStockCode("7668");
//    	System.out.println(stock2);

    	/** update **/
//    	stock2.setStockName("HAIO-1");
//    	stockBo.update(stock2);

    	/** delete **/
//    	stockBo.delete(stock2);

    	System.out.println("Done");
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
