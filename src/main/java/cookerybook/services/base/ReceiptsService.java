package cookerybook.services.base;

import cookerybook.entities.Receipt;
import java.util.List;

public interface ReceiptsService {
    List<Receipt> getAllReceipts();

    Receipt getReceiptById(int id);

    void createReceipt(Receipt receipt);

    void updateReceipt(Receipt receipt);

    void deleteReceipt(Receipt receipt);

    List<Receipt> getReceiptsByCategory(String category);
}
