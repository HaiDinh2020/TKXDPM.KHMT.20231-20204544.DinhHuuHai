CREATE TABLE aims.Media (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(45) NOT NULL,
  price INT NOT NULL,
  quantity INT NOT NULL,
  title VARCHAR(45) NOT NULL,
  value INT NOT NULL,
  imageUrl VARCHAR(45) NOT NULL
);

-- Bảng "CD"
CREATE TABLE aims.CD (
  id INT PRIMARY KEY,
  artist VARCHAR(45) NOT NULL,
  recordLabel VARCHAR(45) NOT NULL,
  musicType VARCHAR(45) NOT NULL,
  releasedDate DATE,
  CONSTRAINT fk_CD_Media1 FOREIGN KEY (id) REFERENCES Media (id)
);

-- Bảng "Book"
CREATE TABLE aims.Book (
  id INT PRIMARY KEY,
  author VARCHAR(45) NOT NULL,
  coverType VARCHAR(45) NOT NULL,
  publisher VARCHAR(45) NOT NULL,
  publishDate DATETIME NOT NULL,
  numOfPages INT NOT NULL,
  language VARCHAR(45) NOT NULL,
  bookCategory VARCHAR(45) NOT NULL,
  CONSTRAINT fk_Book_Media1 FOREIGN KEY (id) REFERENCES Media (id)
);

-- Bảng "DeliveryInfo"
CREATE TABLE aims.DeliveryInfo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45),
  province VARCHAR(45),
  instructions VARCHAR(200),
  address VARCHAR(100)
);

-- Bảng "Card"
CREATE TABLE aims.Card (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cardCode VARCHAR(15) NOT NULL,
  owner VARCHAR(45) NOT NULL,
  cvvCode VARCHAR(3) NOT NULL,
  dateExpired VARCHAR(4) NOT NULL
);

-- Bảng "DVD"
CREATE TABLE aims.DVD (
  id INT PRIMARY KEY,
  discType VARCHAR(45) NOT NULL,
  director VARCHAR(45) NOT NULL,
  runtime INT NOT NULL,
  studio VARCHAR(45) NOT NULL,
  subtitle VARCHAR(45) NOT NULL,
  releasedDate DATETIME,
  CONSTRAINT fk_DVD_Media1 FOREIGN KEY (id) REFERENCES Media (id)
);

CREATE TABLE aims.Order (
  id INT NOT NULL,
  shippingFees VARCHAR(45),
  deleveryInfoId INT NOT NULL,
  PRIMARY KEY (id, deleveryInfoId),
  CONSTRAINT fk_Order_DeliveryInfo1 FOREIGN KEY (deleveryInfoId) REFERENCES DeliveryInfo (id)
);

-- Bảng "OrderMedia"
CREATE TABLE aims.OrderMedia (
  orderID INT NOT NULL,
  price INT NOT NULL,
  quantity INT NOT NULL,
  mediaId INT NOT NULL,
  PRIMARY KEY (orderID, mediaId),
  CONSTRAINT fk_OrderMedia_Order FOREIGN KEY (orderID) REFERENCES aims.Order (id),
  CONSTRAINT fk_OrderMedia_Media1 FOREIGN KEY (mediaId) REFERENCES Media (id)
);

-- Bảng "Invoice"
CREATE TABLE aims.Invoice (
  id INT PRIMARY KEY,
  totalAmount INT NOT NULL,
  orderId INT NOT NULL,
  CONSTRAINT fk_Invoice_Order1 FOREIGN KEY (orderId) REFERENCES aims.Order (id)
);

-- Bảng "PaymentTransaction"
CREATE TABLE aims.PaymentTransaction (
  id INT NOT NULL,
  createAt DATETIME NOT NULL,
  content VARCHAR(45) NOT NULL,
  method VARCHAR(45),
  cardId INT NOT NULL,
  invoiceId INT NOT NULL,
  PRIMARY KEY (id, cardId, invoiceId),
  CONSTRAINT fk_PaymentTransaction_Card1 FOREIGN KEY (cardId) REFERENCES Card (id),
  CONSTRAINT fk_PaymentTransaction_Invoice1 FOREIGN KEY (invoiceId) REFERENCES Invoice (id)
);