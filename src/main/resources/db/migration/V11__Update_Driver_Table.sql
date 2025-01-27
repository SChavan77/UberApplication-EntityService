ALTER TABLE driver
     ADD driver_approval_status ENUM( 'APPROVED',
                                         'DENIED',
                                         'PENDING') NULL,
    ADD last_known_location_id BIGINT NULL,
    ADD home_location_id BIGINT NULL,
    ADD active_city VARCHAR(255) NULL,
    ADD average_rating DOUBLE NOT NULL,
    ADD is_available BIT(1) NULL;

ALTER TABLE driver
    ADD CONSTRAINT check_driver_rating CHECK (driver.average_rating>=0 AND driver.average_rating<=5);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_HOME_LOCATION FOREIGN KEY (home_location_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_LAST_KNOWN_LOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);