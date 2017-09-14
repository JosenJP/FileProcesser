package com.IFRS.FileProcesser.Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;

public class BaseReader implements IReader
{
    protected Reader reader;
    protected ReadType type;
    protected File file;
    
    public BaseReader(String fileName)
    {
        reader = null;
        type = ReadType.None;
        file = new File(fileName);
    }
    
    public ReadType GetReadType()
    {
        return type;
    }
    
    public String ReadLine()
    {
        GetReader();
        return null;
    }
    
    public void SetLineNumber(int lineNumber)
    {
        
    }

    private void GetReader()
    {
        try
        {
            if (null == reader)
            {
                reader = JReaderFactory.GetReader(type, file);
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
