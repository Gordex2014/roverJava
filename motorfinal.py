import socket
import sys
import time
import RPi.GPIO as GPIO

GPIO.setwarnings(False)
GPIO.cleanup()

mode=GPIO.getmode()

PinAdelante1=16
PinAtras1=18
PinAdelante2=11
PinAtras2=13
sleeptime=1

GPIO.setmode(GPIO.BOARD)
GPIO.setup(PinAdelante1, GPIO.OUT)
GPIO.setup(PinAtras1, GPIO.OUT)
GPIO.setup(PinAdelante2, GPIO.OUT)
GPIO.setup(PinAtras2, GPIO.OUT)

def adelante(x):
    GPIO.output(PinAdelante1, GPIO.HIGH)
    GPIO.output(PinAdelante2, GPIO.HIGH)
    print ("Adelante")
    time.sleep(x)
    GPIO.output(PinAdelante1, GPIO.LOW)
    GPIO.output(PinAdelante2, GPIO.LOW)

def atras(x):
    GPIO.output(PinAtras1, GPIO.HIGH)
    GPIO.output(PinAtras2, GPIO.HIGH)
    print ("Atras")
    time.sleep(x)
    GPIO.output(PinAtras1, GPIO.LOW)
    GPIO.output(PinAtras2, GPIO.LOW)

def derecha(x):
    GPIO.output(PinAdelante1, GPIO.HIGH)
    GPIO.output(PinAtras2, GPIO.HIGH)
    print ("Derecha")
    time.sleep(x)
    GPIO.output(PinAdelante1, GPIO.LOW)
    GPIO.output(PinAtras2, GPIO.LOW)

def izquierda(x):
    GPIO.output(PinAdelante2, GPIO.HIGH)
    GPIO.output(PinAtras1, GPIO.HIGH)
    print ("Izquierda")
    time.sleep(x)
    GPIO.output(PinAdelante2, GPIO.LOW)
    GPIO.output(PinAtras1, GPIO.LOW)
    
host = ''

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
 
s.bind((host, 12345))

print ('conexion abierta')

s.listen(1)

while True:
    
    sc, addr = s.accept()

    recibido = sc.recv(1024)
    
    letra = recibido[2]

    #Cuando se hace un stream por sockets y lo hago en java, incluso en el
    #raspberry pi funciona con normalidad, sin embargo cuando lo hago en python
    #recibo dos datos basura al principio

    if (letra == a)

        adelante(0.15)

    if (letra == b)

        atras(0.15)

    if (letra == i)

        izquierda(0.05)

    if (letra == d)

        derecha(0.05)

    #Notese como se controlaba el auto por pulsos, debido a que si enviaba una
    #sucesion de caracteres los motores podian dañarse debido al constante prendido
    #y apagado
