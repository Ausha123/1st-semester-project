package pos.dao.custom.impl;

import pos.dao.CrudUtil;
import pos.dao.custom.BookDAO;
import pos.entity.Book;
import pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean save(Book book) throws Exception {
        return CrudUtil.execute
                    ("INSERT INTO Books VALUES(?,?,?,?,?,?,?,?)",
                    book.getId(),book.getName(),book.getAuthor(),book.getPubDate(),book.getUnits(),book.getIsbn(),book.getCategory(),book.getPrice());

        }

    @Override
    public boolean update(Book book) throws Exception {
        return CrudUtil.execute
                ("UPDATE Books SET Title=?,Author=?,publishedDate=?,Units=?,ISBN=?,Category=?,Price=? WHERE BID=? ",
                        book.getName(),book.getAuthor(),book.getPubDate(),book.getUnits(),book.getIsbn(),book.getCategory(),book.getPrice(),book.getId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Books WHERE BID=?",s);
    }

    @Override
    public Book get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Books WHERE BID=?",s);
        if(resultSet.next()) {
            return new Book(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDouble(8)
            );

        }else{
            return null;

        }
    }

    @Override
    public ArrayList<Book> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Books");
        ArrayList<Book> BookArrayList = new ArrayList<>();
        while (resultSet.next()){
            BookArrayList.add(
                    new Book(
                            resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                            resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                            resultSet.getString(7),resultSet.getDouble(8)));


        }
        return BookArrayList;
    }
}

