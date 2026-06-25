package co.istad.chhaya.ecommerce.features.file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository
        extends JpaRepository<FileUpload, Long> {
}
