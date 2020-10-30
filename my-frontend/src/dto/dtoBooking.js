export default class dtoBooking {
  constructor(id_vehicle, email, checkIn, checkOut) {
    this.id_vehicle = id_vehicle;
    this.email = email;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}