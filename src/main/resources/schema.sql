-- Crear tabla User
CREATE TABLE IF NOT EXISTS "User" (
                                      id SERIAL PRIMARY KEY,
                                      username VARCHAR(50) UNIQUE NOT NULL,
                                      password VARCHAR(255) NOT NULL
);

-- Crear tabla Person
CREATE TABLE IF NOT EXISTS "Person" (
                                        id SERIAL PRIMARY KEY,
                                        fullname VARCHAR(100) NOT NULL,
                                        age INT NOT NULL,
                                        status VARCHAR(10) CHECK (status IN ('active', 'inactive')) NOT NULL
);

-- Crear tabla Device
CREATE TABLE IF NOT EXISTS "Device" (
                                        id SERIAL PRIMARY KEY,
                                        description VARCHAR(255) NOT NULL
);

-- Crear tabla Session
CREATE TABLE IF NOT EXISTS "Session" (
                                         id SERIAL PRIMARY KEY,
                                         create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         person_id INT NOT NULL,
                                         device_id INT NOT NULL,
                                         user_id INT NOT NULL,
                                         FOREIGN KEY (person_id) REFERENCES "Person"(id),
                                         FOREIGN KEY (device_id) REFERENCES "Device"(id),
                                         FOREIGN KEY (user_id) REFERENCES "User"(id)
);

-- Crear tabla Event
CREATE TABLE IF NOT EXISTS "Event" (
                                       id SERIAL PRIMARY KEY,
                                       letter CHAR(1) NOT NULL,
                                       time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
