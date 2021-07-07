package pos.bo.custom.impl;

import pos.bo.custom.BookBO;
import pos.dao.DaoFactory;
import pos.dao.QueryDAO;
import pos.dao.custom.BookDAO;
import pos.dao.custom.CustomerDAO;
import pos.dto.BookDTO;
import pos.dto.CustomerDTO;
import pos.entity.Book;
import pos.entity.Customer;

import java.util.ArrayList;

public class BookBOImpl implements BookBO {
    private BookDAO bookDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.BOOKS);
    private QueryDAO queryDAO = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);


    @Override
    public boolean saveBook(BookDTO dto) throws Exception {
        return bookDAO.save(new Book(dto.getId(),dto.getName(),dto.getAuthor(),dto.getPubDate(),
        dto.getUnits(),dto.getIsbn(),dto.getCategory(),dto.getPrice()));
    }

    @Override
    public boolean updateBook(BookDTO dto) throws Exception {
        return bookDAO.update(new Book(dto.getId(),dto.getName(),dto.getAuthor(),
                dto.getPubDate(),dto.getUnits(),dto.getIsbn(),dto.getCategory(),dto.getPrice()));
    }

    @Override
    public boolean deleteBook(String id) throws Exception {
        return bookDAO.delete(id);
    }

    @Override
    public BookDTO getBook(String id) throws Exception {
        Book book = bookDAO.get(id);
       return new BookDTO(book.getId(),book.getName(),book.getAuthor(),
               book.getPubDate(),book.getUnits(),book.getIsbn(),book.getCategory(),book.getPrice());
    }

    @Override

        public ArrayList<BookDTO> getAllBooks() throws Exception {
            ArrayList<Book> bookArrayList = bookDAO.getAll();
            ArrayList<BookDTO> dtoArrayList = new ArrayList();
            for (Book book : bookArrayList) {
                dtoArrayList.add(new BookDTO(book.getId(), book.getName(), book.getAuthor(),
                        book.getPubDate(),book.getUnits(),book.getIsbn(),book.getCategory(),book.getPrice()));
            }
            return dtoArrayList;
    }

    @Override
    public String getBookId() throws Exception {
        return queryDAO.getBookId();
    }
}
