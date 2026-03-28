import secrets
import string

def genera_password_personalizzata():
    print("--- Configura la tua Password ---")
    
    # Input dell'utente
    totale = int(input("Lunghezza totale della password: "))
    n_maiuscole = int(input("Quante lettere MAIUSCOLE? "))
    n_minuscole = int(input("Quante lettere minuscole? "))
    n_numeri = int(input("Quanti numeri? "))
    n_speciali = int(input("Quanti caratteri speciali? "))

    # Verifica coerenza
    somma_richiesta = n_maiuscole + n_minuscole + n_numeri + n_speciali
    
    if somma_richiesta > totale:
        print(f"\nErrore: Hai richiesto {somma_richiesta} caratteri, ma la lunghezza totale è {totale}!")
        return

    # Preparazione dei componenti
    password_list = []
    password_list += [secrets.choice(string.ascii_uppercase) for _ in range(n_maiuscole)]
    password_list += [secrets.choice(string.ascii_lowercase) for _ in range(n_minuscole)]
    password_list += [secrets.choice(string.digits) for _ in range(n_numeri)]
    password_list += [secrets.choice(string.punctuation) for _ in range(n_speciali)]

    # Se avanzano spazi, li riempiamo con caratteri misti (default)
    rimanenti = totale - somma_richiesta
    if rimanenti > 0:
        pool_misto = string.ascii_letters + string.digits + string.punctuation
        password_list += [secrets.choice(pool_misto) for _ in range(rimanenti)]

    # Mescoliamo la lista per non avere l'ordine fisso (es. prima tutte maiuscole, poi numeri...)
    secrets.SystemRandom().shuffle(password_list)

    # Uniamo in una stringa
    password_finale = "".join(password_list)
    
    print("\n" + "="*30)
    print(f"Password generata: {password_finale}")
    print("="*30)

if __name__ == "__main__":
    genera_password_personalizzata()