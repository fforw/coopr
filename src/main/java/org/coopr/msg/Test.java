package org.coopr.msg;

/**
 * Login message.
 * 
 * @author shelmberger
 */
public class Test
    extends ApplicationMessage
{
    private int count = 1;


    public int getCount()
    {
        return count;
    }


    public void setCount(int count)
    {
        this.count = count;
    }


    public void increment()
    {
        count++;
    }

}
