package cookerybook.services;

import cookerybook.entities.Receipt;
import cookerybook.repositories.base.GenericRepository;
import cookerybook.services.base.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;

public class ReceiptsServiceImpl implements ReceiptsService {

    private final GenericRepository<Receipt> receiptsRepository;

    @Autowired
    public ReceiptsServiceImpl(GenericRepository<Receipt> receiptsRepository) {
        this.receiptsRepository = receiptsRepository;
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptsRepository.getAll();
    }

    @Override
    public Receipt getReceiptById(int id) {
        return receiptsRepository.getById(id);
    }

    @Override
    public void createReceipt(Receipt receipt) {
        receiptsRepository.create(receipt);
    }

    @Override
    public void updateReceipt(Receipt receipt) {
        receiptsRepository.update(receipt);
    }

    @Override
    public void deleteReceipt(Receipt receipt) {
        receiptsRepository.delete(receipt);
    }

    @Override
    public List<Receipt> getReceiptsByCategory(String categoryName) {
        List<Receipt> receipts = receiptsRepository.getAll();

        return receipts.stream()
                .filter(receipt -> receipt.getCategory().getName().equals(categoryName))
                .collect(Collectors.toList());
    }
}
