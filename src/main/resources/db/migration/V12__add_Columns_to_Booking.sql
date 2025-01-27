ALTER TABLE booking
    ADD pick_up_location_id BIGINT NULL,
    ADD drop_location_id BIGINT NULL;


ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_DROP_LOCATION FOREIGN KEY (drop_location_id) REFERENCES exact_location (id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_PICK_UP_LOCATION FOREIGN KEY (pick_up_location_id) REFERENCES exact_location (id);
