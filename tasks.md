
### TASKS

test1

- python script that displays all possible json pros of spell

- create a inheritable class tree for all json props of spells (with interfaces/abstract classes for different types - cones, spheres...)

- add statusEffects from page (flying, darkvision... bool passives)

- ItemEffect conversion

- Change Spell structure, add Target class & enum (self, ally, enemy, aura, point, aoe, cone) that contains ranges, cones

- keep seperate track of maxHP from character and bonus HP from effects, probably need bonus HP counter (render it in a different color - orange)

- finish races & subraces enums, classes and sublclasses enums

- I can program in the resistances if I manually damage by type

- https://bg3.wiki/wiki/Weapon_actions

- add auto-calculation of base damage (stats + equipped weapon), AC, and a bunch of other stats

- finish all statuseffects enum

- make a static playable races list in Race enum

- change "Elemental Weapon" spell so it doesn't give +1 to both Attack roll and damgae roll, but only to attack roll

- add a clickable damage object in log that auto copies the damage into calculator (or just queues text pointer on appropriate damage types)

- also need a appliesStatusEffect property of spell (clickable in log and can be dragged to a creature)

- ilia moze povezivat spellove i StatusEffecte

- add like 10 ClassActions to list

- promjeni spell upcastove u true na lv1 spellovima gdje treba

- Creature.spellbook (will need primary ability of source of learned spell (which class/race) to calculate save DC), sort spellbook by school, ability to favourite spells

- prepared spells (how different classes do it)

- Creature.cast() players can ping spells and attacks (Flint casts Icebolt and it does 3d6+5 frost damage) (Flint uses melee attack and it does 3d6+5 bludgeoning damage)

- sort race and class TurnResource counters to different objects/classes

- when taking damage and checking StatusEffects (ex. resistances) there is an empty list of possible procs and procs get added if true so output can be ˇˇ

- "(0, 10, 0, 6, 0, 0, 0) -> Goblin has taken 8 damage (COLD_RESISTANCE, POISON_RESISTANCE)"

- need to be able to display/preview summon's abilities before summoning them 
    
- go through each statuseffect and program it in.

- go through actual dnd (not bg3) subraces, subclasses, spells, conditions and add/modify the ones you have

- Postman website or vsc extension for POST requests

- --- WEBAPP RESEARCH & CONVERSION TIME ---

- Item image

- kad ce trebat dodavat slike spellova to moze ilia 

- change item.lastModified on move between inventories (add function inventory.moveItem(itemIndex, otherInventory) or something)

- highlight item in inventory on move/modify

- finish all spells list

- Item can be lootable, add ability to save inventories (probably to database) outside player's inventories (if they intentionally drop some bag), print out its location coordinates and inventories recursively 

- add sorting options for inventory

- print shit out and save it to a log file simultaneously

- player inventory actions come as requests to me with checkmark or x to approve or dissmiss (ability to lock each inventory)

- stack splitting when transfering item

- add trading: buying and selling items (trader has buy and sell modifiers that can be changed by spells )

- Go through each class, subclass, race and subrace and imagine trying to level them up

- add hierarchy list of Ability Checks, Saving Throws and Attack Roll to see all possible bonuses

- do i even need a Creature class or a PlayableCharacter class ?

- display resistances & relevant passives in combat (like minecraft)

- add "pop" sound (similiar to minecraft item pickup) to equip and inventory actions

- COMBAT TAB with quick resource counter control for all

- SCENE TAB with Items













### Windows Hard link command:

```batch
mklink /H "E:\Alexandria\D&D\tabletop-assistant-tasks-copy.md" "E:\Programming\tabletop-assistant\tasks.md"
```





### ILIA TASKS

1 square ~2.5cm 
popunit spellove u kodu na githubu (GameData.java), popunit subclasses u kodu na githubu (GameClass.java), koliki ce bit: gridmap PC movement range, gridmap spell range, gridmap aoe spells, improvised throw weapon range, 2 ranged weapon ranges (shorter one with disadvantage), kako funkcioniraju hit dice (short rest, long rest, levelup), koji ability za attack roll a koji za damage roll, weapon types and scaling (finesse, versatile, martial...)
DnD 5e Players Handbook (BnW OCR)
D&D 5e Dungeon Master's Guide ( PDFDrive)
5th Edition - Essentials Kit Rulebook

---

nauci kak funkcionira git i github (add, commit, pull, push, branch, merge, pull request) zato da mi mozes contributat u kod bez mog inputa i samo pull requestat

dodavat spellove koji fale u json-u i pregledat ove bg3 spellove koji su tu jel su isti efekti i ako nisu odabrat koji se cini bolji

povezat spellove i status effecte u kodu

https://bg3.wiki/wiki/Weapons#Properties

dodavanje slika spellovima

convertat feet u squares svugdje u kodu



