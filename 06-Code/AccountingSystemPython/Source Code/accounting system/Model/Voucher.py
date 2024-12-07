import Client
import Supplier
class Voucher:
    def __init__ (self,type,id,issue_date,client,supplier,VAT,subtotal,value_with_VAT,total,payment_method):
        self.type = type
        self.id = id
        self.issue_date = issue_date
        self.client = client
        self.supplier = supplier
        self.VAT = VAT
        self.subtotal = subtotal
        self.value_with_VAT = value_with_VAT
        self.total = total
        self.payment_method = payment_method

