# 🏰 Medieval Kingdom - Yazılım Tasarım Desenleri Projesi

Orta Çağ temalı bir krallık yönetim sistemi. Bu proje, yazılım tasarım desenlerini (Design Patterns) Java programlama dili ile göstermek için hazırlanmıştır.

## 📋 İçindekiler

- [Kullanılan Tasarım Desenleri](#-kullanılan-tasarım-desenleri)
- [Proje Yapısı](#-proje-yapısı)
- [Kurulum ve Çalıştırma](#-kurulum-ve-çalıştırma)
- [Desen Açıklamaları](#-desen-açıklamaları)

## ⚔️ Kullanılan Tasarım Desenleri

| Kategori | Desen | Açıklama |
|----------|-------|----------|
| **Creational** | Singleton | Tek krallık instance'ı |
| **Creational** | Factory | Farklı asker türleri üretimi |
| **Creational** | Builder | Adım adım kale inşası |
| **Structural** | Decorator | Zırh geliştirmeleri |
| **Structural** | Adapter | Eski silah sistemi adaptasyonu |
| **Structural** | Facade | Savaş sistemi basitleştirme |
| **Behavioral** | Strategy | Farklı saldırı stratejileri |
| **Behavioral** | Observer | Krallık olay bildirimleri |
| **Behavioral** | Command | Savaş komutları ve geri alma |

## 📁 Proje Yapısı

```
MiddleEra/
├── src/
│   └── com/
│       └── medievalkingdom/
│           ├── Main.java                    # Ana giriş noktası
│           │
│           ├── creational/                  # Oluşturucu Desenler
│           │   ├── singleton/
│           │   │   └── Kingdom.java         # Singleton - Tek krallık
│           │   ├── factory/
│           │   │   ├── Soldier.java         # Asker arayüzü
│           │   │   ├── Knight.java          # Şövalye
│           │   │   ├── Archer.java          # Okçu
│           │   │   ├── Infantry.java        # Piyade
│           │   │   └── SoldierFactory.java  # Asker fabrikası
│           │   └── builder/
│           │       ├── Castle.java          # Kale sınıfı
│           │       └── CastleBuilder.java   # Kale inşaatçısı
│           │
│           ├── structural/                  # Yapısal Desenler
│           │   ├── decorator/
│           │   │   ├── Armor.java           # Zırh arayüzü
│           │   │   ├── BasicArmor.java      # Temel zırh
│           │   │   ├── ArmorDecorator.java  # Soyut decorator
│           │   │   ├── ChainmailDecorator.java
│           │   │   ├── PlateDecorator.java
│           │   │   └── HelmetDecorator.java
│           │   ├── adapter/
│           │   │   ├── OldWeapon.java       # Eski silah sistemi
│           │   │   ├── ModernWeapon.java    # Yeni silah arayüzü
│           │   │   └── WeaponAdapter.java   # Adapter
│           │   └── facade/
│           │       └── BattleFacade.java    # Savaş cephesi
│           │
│           └── behavioral/                  # Davranışsal Desenler
│               ├── strategy/
│               │   ├── AttackStrategy.java  # Strateji arayüzü
│               │   ├── AggressiveAttack.java
│               │   ├── DefensiveAttack.java
│               │   └── GuerrillaAttack.java
│               ├── observer/
│               │   ├── KingdomEvent.java    # Olay sınıfı
│               │   ├── KingdomObserver.java # Observer arayüzü
│               │   ├── KingdomSubject.java  # Subject sınıfı
│               │   ├── RoyalAdvisor.java    # Danışman observer
│               │   └── Spy.java             # Casus observer
│               └── command/
│                   ├── BattleCommand.java   # Komut arayüzü
│                   ├── AttackCommand.java
│                   ├── DefendCommand.java
│                   ├── RetreatCommand.java
│                   └── BattleInvoker.java   # Komut yürütücü
└── README.md
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler
- Java JDK 11 veya üzeri

### Derleme
```bash
cd MiddleEra
javac -d out -encoding UTF-8 src/com/medievalkingdom/**/*.java src/com/medievalkingdom/*.java
```

### Çalıştırma
```bash
java -cp out com.medievalkingdom.Main
```

## 📖 Desen Açıklamaları

### 1. Singleton Pattern (Creational)
**Sınıf:** `Kingdom`

Krallık tek bir instance olarak yönetilir. `getInstance()` metodu her zaman aynı Kingdom nesnesini döndürür.

```java
Kingdom kingdom = Kingdom.getInstance();
Kingdom sameKingdom = Kingdom.getInstance();
// kingdom == sameKingdom -> true
```

### 2. Factory Pattern (Creational)
**Sınıf:** `SoldierFactory`

Farklı asker türlerini (Knight, Archer, Infantry) client kodun concrete sınıfları bilmesine gerek kalmadan oluşturur.

```java
Soldier knight = SoldierFactory.createSoldier(SoldierType.KNIGHT);
Soldier archer = SoldierFactory.createSoldier(SoldierType.ARCHER);
```

### 3. Builder Pattern (Creational)
**Sınıf:** `CastleBuilder`

Karmaşık Castle nesnelerini adım adım, fluent interface ile oluşturur.

```java
Castle castle = new CastleBuilder("Kartal Yuvası")
    .addTowers(6)
    .addWalls(12)
    .addMoat()
    .addDrawbridge()
    .build();
```

### 4. Decorator Pattern (Structural)
**Sınıflar:** `ArmorDecorator`, `ChainmailDecorator`, `PlateDecorator`, `HelmetDecorator`

Temel zırhı dinamik olarak yeni özelliklerle genişletir.

```java
Armor armor = new BasicArmor();
armor = new ChainmailDecorator(armor);
armor = new PlateDecorator(armor);
armor = new HelmetDecorator(armor);
// Her decorator savunma ve ağırlık ekler
```

### 5. Adapter Pattern (Structural)
**Sınıf:** `WeaponAdapter`

Eski silah sistemini (OldWeapon) yeni arayüze (ModernWeapon) uyarlar.

```java
OldWeapon oldSword = new OldWeapon("Antik Kılıç", 50);
ModernWeapon adapted = new WeaponAdapter(oldSword);
adapted.attack(); // Yeni arayüzü kullanır
```

### 6. Facade Pattern (Structural)
**Sınıf:** `BattleFacade`

Karmaşık savaş sistemini basit metodlarla kullanılabilir hale getirir.

```java
BattleFacade battle = new BattleFacade();
battle.setStrategy(new GuerrillaAttack());
battle.startBattle("Düşman Ordusu");
```

### 7. Strategy Pattern (Behavioral)
**Arayüz:** `AttackStrategy`
**Stratejiler:** `AggressiveAttack`, `DefensiveAttack`, `GuerrillaAttack`

Saldırı davranışını runtime'da değiştirmeye olanak tanır.

```java
AttackStrategy strategy = new AggressiveAttack();
strategy.execute(soldiers);

strategy = new GuerrillaAttack();
strategy.execute(soldiers);
```

### 8. Observer Pattern (Behavioral)
**Arayüz:** `KingdomObserver`
**Observer'lar:** `RoyalAdvisor`, `Spy`

Krallıktaki olayları dinleyen gözlemciler sistem.

```java
kingdom.attach(new RoyalAdvisor("Vezir"));
kingdom.attach(new Spy("Gölge"));
kingdom.addGold(100); // Tüm observer'lar bilgilendirilir
```

### 9. Command Pattern (Behavioral)
**Arayüz:** `BattleCommand`
**Komutlar:** `AttackCommand`, `DefendCommand`, `RetreatCommand`

Komutları nesne olarak kapsüller, yürütme ve geri alma işlevselliği sağlar.

```java
BattleInvoker invoker = new BattleInvoker();
invoker.executeCommand(new AttackCommand(soldiers));
invoker.executeCommand(new DefendCommand(soldiers));
invoker.undoLastCommand(); // Son komutu geri al
```

## 👨‍💻 Geliştirici

Bu proje yazılım tasarım desenleri dersi için hazırlanmıştır.

## 📄 Lisans

MIT License
