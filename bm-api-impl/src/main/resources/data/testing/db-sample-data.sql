INSERT INTO "PA165"."HOTEL" ("ID", "NAME") VALUES (1, 'Imperial'), (2, 'Hotel New York'), (3, 'Hotel Washington');

INSERT INTO "PA165"."ROOM"
      ("ID", "HOTEL_ID", "NUMBER", "PRICE")
  VALUES
      (1, 1, '101', 29.99),
      (2, 1, '102', 49.99),
      (3, 1, '103', 49.99),
      (4, 1, '104', 49.99),
      (5, 2, '101', 49.99),
      (6, 2, '102', 49.99),
      (7, 2, '103', 49.99),
      (8, 2, '104', 49.99)
;

INSERT INTO "PA165"."RESERVATION"
      ("ID", "ROOM_ID", "CUSTOMER_NAME", "CUSTOMER_EMAIL", "CUSTOMER_PHONE", "RESERVATION_FROM", "RESERVATION_TO")
  VALUES
      (1, 1, 'Jakub Polák', 'jakub@polak.com', '111 222 333', '1990-10-10', '1990-10-17'),
      (2, 2, 'Steve Jobs', 'steve@jobs.com', '123 456 789', '2000-01-01', '2000-02-10'),
      (3, 5, 'Linus Torvalds', 'linus@torvalds.com', '012 012 012', '1985-10-10', '1985-11-01'),
      (4, 6, 'Mahatma Gandhi', 'mahatma@gandhi.com', '333 333 333', '1999-05-01', '1999-05-08')
;

INSERT INTO "PA165"."ROLE" ("ID", "NAME") VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_RECEPTIONIST');

INSERT INTO "PA165"."USER"
      ("ID", "ROLE_ID", "EMAIL", "PASSWORD")
  VALUES
      (1, 1, 'admin@bm.com', 'f613a2ae7af9039d3a371abf0a65d4751e3aed23'),
      (2, 2, 'receptionist@bm.com', 'f613a2ae7af9039d3a371abf0a65d4751e3aed23')
;
