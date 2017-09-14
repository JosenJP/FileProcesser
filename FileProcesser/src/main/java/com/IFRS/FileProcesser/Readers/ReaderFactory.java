package com.IFRS.FileProcesser.Readers;

public class ReaderFactory
{
    public static BaseReader GetReader(String fileName, ReadType readType)
    {
        BaseReader baseReader = null;
        
        switch (readType)
        {
        case Line:
        {
            baseReader = new LineReader(fileName);
            break;
        }
        case Random:
        {
            break;
        }
        default:
            break;
        }
        
        return baseReader;
    }
}
