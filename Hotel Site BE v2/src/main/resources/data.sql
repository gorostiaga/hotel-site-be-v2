-- For RoomType
INSERT INTO `PUBLIC`.`room_types` (`id`, `name`, `price_per_night`)
VALUES ('1','cabin', '360');
INSERT INTO `PUBLIC`.`room_types` (`id`, `name`, `price_per_night`)
VALUES ('2','bed_room', '360');

-- For Room and its Set of Images
INSERT INTO `PUBLIC`.`rooms` (`id`, `name`, `beds`, `min_people`, `max_people`, `description`, `room_type_id`)
VALUES ('1', 'Cabaña 1', 5, '3', '6', 'Super Comoda', '1');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_1/cabin_1_1.jpg', 'master','1');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_1/cabin_1_2.jpg', 'cabin_1_2','1');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_1/cabin_1_3.jpg', 'cabin_1_3','1');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_1/cabin_1_4.jpg', 'cabin_1_4','1');

INSERT INTO `PUBLIC`.`rooms` (`id`, `name`, `beds`, `min_people`, `max_people`, `description`, `room_type_id`)
VALUES ('2', 'Cabaña 6', 3, '2', '4', 'la puerca', '1');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_6/cabin_6_1.jpg', 'master','2');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_6/cabin_6_2.jpg', 'cabin_6_2','2');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_6/cabin_6_3.jpg', 'cabin_6_3','2');

INSERT INTO `PUBLIC`.`rooms` (`id`, `name`, `beds`, `min_people`, `max_people`, `description`, `room_type_id`)
VALUES ('3', 'Habitacion 8', 2, '2', '3', 'Con refri', '2');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_3/cabin_3_1.jpg', 'master','3');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_3/cabin_3_2.jpg', 'cabin_3_2','3');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_3/cabin_3_3.jpg', 'cabin_3_3','3');
INSERT INTO `PUBLIC`.`room_images` (`file_path`, `description`, `room_id`)
VALUES ('https://raw.githubusercontent.com/gorostiaga/Images/main/finca%20web/cabin_3/cabin_3_4.jpg', 'cabin_3_4','3');

-- For PaymentMethod
INSERT INTO `PUBLIC`.`payment_methods` (`id`, `payment_type`)
VALUES ('1', 'QR');

-- For Customer
INSERT INTO `PUBLIC`.`customers` (`id_customer`, `first_name`, `last_name`, `email`, `phone`, `origin_city`)
VALUES ('666666', 'Amaru', 'Mamani', 'kicos@mamani.net', '70512345', 'Pacasa Land');

--For Booking
INSERT INTO `PUBLIC`.`bookings` (`id`, `checkin_date`, `checkout_date`, `number_people`, `paid_amount`, `creation_date`, `bookings_status`, `room_id`, `customer_id`, `payment_method_id`)
VALUES ('1', '2023-05-01', '2023-05-03', '3', '2160','2023-04-02 17:28:53.04', 'PRE_BOOKED', '1', '666666','1')
