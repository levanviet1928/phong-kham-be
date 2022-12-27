CREATE TABLE patient (
                         patient_id varchar(36) NOT NULL,
                         patient_code varchar(40) NOT NULL,
                         patient_name varchar(500) NOT NULL,
                          age INT NOT NULL,
                          gender varchar(40) NOT NULL,
                          phone INT not null,
                          address varchar(500) NOT NULL,
                      is_deleted INT NULL COMMENT '1 là đã bị xóa, 0 chưa bị xóa'
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_general_ci;