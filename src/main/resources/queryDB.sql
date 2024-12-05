-- 3. Criar tabelas
-- Tabela de restaurantes
CREATE TABLE restaurants (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             cuisine_type VARCHAR(100) NOT NULL,
                             street_address VARCHAR(255) NOT NULL,
                             borough VARCHAR(100) NOT NULL,
                             zipcode VARCHAR(20) NOT NULL,
                             phone_number VARCHAR(15),
                             current_grade CHAR(1),
                             last_inspection_date DATE,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de inspeções
CREATE TABLE inspections (
                             id SERIAL PRIMARY KEY,
                             restaurant_id INT NOT NULL,
                             inspection_date DATE NOT NULL,
                             grade CHAR(1) NOT NULL,
                             comments TEXT,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id)
                                 REFERENCES restaurants (id) ON DELETE CASCADE
);

-- 4. Criar índices para otimização
CREATE INDEX idx_restaurants_borough ON restaurants (borough);
CREATE INDEX idx_restaurants_cuisine ON restaurants (cuisine_type);
CREATE INDEX idx_inspections_restaurant_id ON inspections (restaurant_id);
CREATE INDEX idx_inspections_grade ON inspections (grade);

INSERT INTO restaurants (
    name, cuisine_type, street_address, borough, zipcode, phone_number, current_grade, last_inspection_date
) VALUES (
             'Delicious Eats', 'Italian', '123 Foodie St.', 'Manhattan', '10001', '123-456-7890', 'A', '2024-12-01'
         );

INSERT INTO inspections (
    restaurant_id, inspection_date, grade, comments
) VALUES (
             1, '2024-12-01', 'A', 'Clean and organized kitchen.'
         );

