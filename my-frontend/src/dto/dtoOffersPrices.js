export class dtoOffersPrices {
  constructor() {
    this.offers = [];
    this.totalDays = 0;
    this.finalTotalPrice = 0;
    this.finalTotalDiscount = 0;
    this.defaultTotalPrice = 0;
  }
}

export class dtoToGetPrices {
  constructor(id_vehicle, checkIn, checkOut) {
    this.id_vehicle = id_vehicle;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}