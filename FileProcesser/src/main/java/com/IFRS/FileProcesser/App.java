package com.IFRS.FileProcesser;

import com.IFRS.FileProcesser.Readers.*;

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
        
        BaseReader baseReader = ReaderFactory.GetReader(fileName, ReadType.Line);
        
        while (null != (content = baseReader.ReadLine()))
        {
            System.out.println(content);
        }
    }
}
