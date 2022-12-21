CREATE TABLE account (
                             account_id varchar(36) NOT NULL,
                             user_name varchar(100) NOT NULL,
                             password varchar(100) NOT NULL,
                             is_delete INT NULL COMMENT '1 là đã bị xóa, 0 chưa bị xóa'
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_general_ci;