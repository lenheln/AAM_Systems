-- Создание таблицы Продукты
CREATE TABLE IF NOT EXISTS products (
    id          SERIAL,
    name        TEXT,
    price       INTEGER,
    description TEXT
);