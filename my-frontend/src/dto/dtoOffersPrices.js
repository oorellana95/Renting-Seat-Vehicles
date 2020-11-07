export class dtoOffersPrices {
  constructor() {
    this.offers = [];
    this.totalDays = 0;
    this.finalTotalPrice = 0;
    this.finalTotalDiscount = 0;
    this.defaultTotalPrice = 0;
  }
}

export class dtoOffers {
  constructor(id, name, description, startDate, endDate, cumulative, type, quantity, discountAppliedInRevenues) {
    this.id = id;
    this.name = name;
    this.id = description;
    this.startDatet = startDate;
    this.endDate = endDate;
    this.cumulative = cumulative;
    this.type = type;
    this.quantity = quantity;
    this.discountAppliedInRevenues = discountAppliedInRevenues;
  }
}