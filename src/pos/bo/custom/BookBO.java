package pos.bo.custom;

import pos.dto.BookDTO;
import pos.dto.CustomerDTO;

import java.util.ArrayList;

public interface BookBO {
    public boolean saveBook(BookDTO dto)throws Exception;
    public boolean updateBook(BookDTO dto)throws Exception;
    public boolean deleteBook(String id)throws Exception;
    public BookDTO getBook(String id)throws Exception;
    public ArrayList<BookDTO> getAllBooks() throws Exception;
    public String getBookId() throws Exception;
}
