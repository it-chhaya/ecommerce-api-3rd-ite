package co.istad.chhaya.ecommerce.features.file;

import co.istad.chhaya.ecommerce.features.file.dto.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    List<FileUploadResponse> uploadMultiple(List<MultipartFile> files);

    FileUploadResponse upload(MultipartFile file);

}
