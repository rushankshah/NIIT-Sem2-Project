    
public class BookDetails {
    public int bookid;
    public float price;
    public String bookname,authorname,linkname;
    public char status;
    
    public void setBookId(int bookid)
    {
        this.bookid=bookid;
    }
    public int getBookId()
    {
        return bookid;
    }
    public void setBookName(String bookname)
    {
        this.bookname=bookname;
    }
    public String getBookName()
    {
        return bookname;
    }
    public void setAuthorName(String authorname)
    {
        this.authorname=authorname;
    }
    public String getAuthorName()
    {   
        return authorname;
    }
    public void setPrice(float price)
    {
        this.price=price;
    }
    public float getPrice()
    {
        return price;
    }
    public void setLinkName(String linkname)
    {
        this.linkname=linkname;
    }
    public String getLinkName()
    {
        return linkname;
    }
    public char getStatus()
    {
        return status;
    }
    
}
