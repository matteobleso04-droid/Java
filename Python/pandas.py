import pandas as pd


prezzi = [100,105,103,110,108]

df = prezzi.DataFrame({"prezzo":prezzi})

media = df["prezzo"].mean()

ultimo = df["prezzo"].iloc(-1)

if ultimo >= media:
    print("VERDE")
else:
    print("ROSSO")
