export class dtoBooking {
  constructor(id_vehicle, client, email, checkIn, checkOut) {
    this.id_vehicle = id_vehicle;
    this.email = email;
    this.client = client;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}

export class dtoBookingPrices {
  constructor(id_vehicle, checkIn, checkOut) {
    this.id_vehicle = id_vehicle;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}