class Transaction:
    def __init__ (self,id,type,voucher,payment_status):
        self.id = id
        self.type = type
        self.voucher = voucher
        self.payment = payment_status
        self.payment_stauts = payment_status