

ALTER TABLE passenger_review
    ADD booking_id BIGINT NULL;

ALTER TABLE passenger_review
    MODIFY booking_id BIGINT NOT NULL;

ALTER TABLE passenger_review
    ADD CONSTRAINT uc_passengerreview_booking UNIQUE (booking_id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

