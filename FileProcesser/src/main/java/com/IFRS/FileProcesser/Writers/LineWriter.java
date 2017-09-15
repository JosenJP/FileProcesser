package com.IFRS.FileProcesser.Writers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LineWriter
{
    private RandomAccessFile randomAccessFile;
    private String fileName;
    
    public LineWriter(String fileName)
    {
        this.fileName = fileName;
    }
    
    public void WriteLine(String lineStr, boolean isAppend)
    {
        GetWriter();
        try
        {
            if (isAppend)
            {
                long len = randomAccessFile.length();
                randomAccessFile.seek(len);
            }
            else
            {
                Clean(); //Clean all the content in the file
                randomAccessFile.seek(0);
            }
            String lineContect = lineStr + System.getProperty("line.separator");
            randomAccessFile.write(lineContect.getBytes());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void Close()
    {
        try
        {
            if (null != randomAccessFile)
            {
                randomAccessFile.close();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void Clean()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("");
            fileWriter.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void GetWriter()
    {
        try
        {         
            if (null == randomAccessFile)
            {
                randomAccessFile = new RandomAccessFile(fileName, "rw");
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
