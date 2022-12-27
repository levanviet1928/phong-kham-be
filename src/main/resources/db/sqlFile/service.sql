CREATE TABLE service (
                         service_id varchar(36) NOT NULL,
                         service_code varchar(40) NOT NULL,
                         service_name varchar(500) NOT NULL,
                         price  decimal(18,3) NOT NULL,
                         is_deleted INT NULL COMMENT '1 là đã bị xóa, 0 chưa bị xóa'
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_general_ci;