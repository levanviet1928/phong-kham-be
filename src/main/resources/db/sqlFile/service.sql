CREATE TABLE service
(
    service_id   varchar(36) NOT NULL,
    service_code varchar(40),
    service_name varchar(500),
    price        int,
    is_deleted   INT NULL COMMENT '1 là đã bị xóa, 0 chưa bị xóa'
) ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_general_ci;