ALTER TABLE rider
ADD active_booking_id BIGINT NULL,
ADD average_rating DOUBLE NULL,
ADD last_known_location_id BIGINT NULL,
ADD home_location_id BIGINT NULL;

ALTER TABLE rider ADD CONSTRAINT FK_RIDER_ON_ACTIVE_BOOKING FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE rider ADD CONSTRAINT FK_RIDER_ON_HOME_LOCATION FOREIGN KEY (home_location_id) REFERENCES exact_location (id);

ALTER TABLE rider ADD CONSTRAINT FK_RIDER_ON_LAST_KNOWN_LOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);

ALTER TABLE rider
    ADD CONSTRAINT check_rating CHECK (rider.average_rating>=0 AND rider.average_rating<=5);
