package com.IFRS.FileProcesser;

import com.IFRS.FileProcesser.Readers.*;
import com.IFRS.FileProcesser.Writers.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "H:\\Test.txt";
        
        String content = null;
        
        //Test For Reader
        BaseReader baseReader = ReaderFactory.GetReader(fileName, ReadType.Line);
        while (null != (content = baseReader.ReadLine()))
        {
            System.out.println(content);
        }
        baseReader.Close();
        
        //Test for Writer
        content = "Hello Header";
        LineWriter lineWriter = new LineWriter(fileName);
        lineWriter.WriteLine(content, false);
        lineWriter.Close();
    }
}
