#import yfinance as yf
#import pandas as pd

#def mediaLista(lista):
 #   media = sum(lista)/len(lista)
  #  return media

#l = [x for x in input("Inserisci una lista di numeri: ").split()]
#media = mediaLista(l)
#if l[-1] > media:
#    print("VERDE")
#elif l[-1] < media:
#    print("ROSSO")
#else:
#    print("GIALLO")
    
#azione = {
#    "ticker" : "SPY",
#    "prezzo" : 400,
#    "volume":"non so che vuoldire"
#}
#print(azione["ticker"])
#if azione["prezzo"] > 350:
#    print("VERDE")


def anagrammi(p1, p2):
    if sorted(p1) == sorted(p2):
        return True
    else:
        return False
    
def palindroma(p):
    parola = p.lower()
    parolaf = parola.replace(" ", "")
    return parolaf == parolaf[::-1]

def conta_vocali(s):
    lista = [c for c in s if c in "aeiouAEIOU"]
    return len(lista)

def conta_consonanti(s):
    return len([c for c in s if c.isalpha() and c not in "aeiouAEIOU"])
   

def lettera_frequente(stringa):
    conteggi = {}
    for c in stringa:
        if c.isalpha() in conteggi:
            c = c.lower()
            conteggi[c] += 1
        else:
            conteggi[c] = 1
    return max(conteggi, key=conteggi.get)

studenti = [
    {"nome" : "Luca", "voto": 28},
    {"nome" : "Mario", "voto" : 30},
    {"nome":"Anna", "voto": 25}
]
#migliore = max(studenti, key=lambda s:s["voto"])
#nome  = migliore["nome"]
somma = 0
for s in studenti:
    somma += s["voto"]
media = somma / len(studenti)

#filtrati = [s for s in studenti if s["voto"] >= 28]
ordinata = sorted(studenti, key=lambda s:s["voto"], reverse= True)
media = [
    {"nome" : s["nome"], "media" : sum(s["voto"] / len(s["voto"]))}
    for s in studenti
]

