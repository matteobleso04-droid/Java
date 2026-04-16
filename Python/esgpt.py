import yfinance as yf
import pandas as pd

def mediaLista(lista):
    media = sum(lista)/len(lista)
    return media

l = [x for x in input("Inserisci una lista di numeri: ").split()]
media = mediaLista(l)
if l[-1] > media:
    print("VERDE")
elif l[-1] < media:
    print("ROSSO")
else:
    print("GIALLO")
    
azione = {
    "ticker" : "SPY",
    "prezzo" : 400,
    "volume":"non so che vuoldire"
}
print(azione["ticker"])
if azione["prezzo"] > 350:
    print("VERDE")

