
### TASKS

- python script that displays all possible json pros of spell
- create a inheritable class tree for all json props of spells (with interfaces/abstract classes for different types - cones, spheres...)
- add statusEffects from page (flying, darkvision... bool passives)
- ItemEffect conversion
- change equiped (to ItemStack ?) since indexes can get fucked by moving items
- Change Spell structure, add Target class & enum (self, ally, enemy, aura, point, aoe, cone) that contains ranges, cones
- keep seperate track of maxHP from character and bonus HP from effects, probably need bonus HP counter (render it in a different color - orange)
- finish races & subraces enums, classes and sublclasses enums
- weight and encumbered
- https://bg3.wiki/wiki/Weapon_actions
- add auto-calculation of base damage (stats + equipped weapon), AC, and a bunch of other stats
- finish all statuseffects enum
- update the spell descriptions by making them more descriptive and dnd-like (as a contrast to crpg-like) https://roll20.net/compendium/dnd5e/Index%3ASpells
- make a static playable races list in Race enum
- change "Elemental Weapon" spell so it doesn't give +1 to both Attack roll and damgae roll, but only to attack roll
- add a clickable damage object in log that auto copies the damage into calculator (or just queues text pointer on appropriate damage types)
- also need a appliesStatusEffect property of spell (clickable in log and can be dragged to a creature)
- ilia moze povezivat spellove i StatusEffecte
- add like 10 ClassActions to list
- go look through monsters statblocks for missing statuseffects 
- Creature.spellbook (will need primary ability of source of learned spell to calculate save DC), sort spellbook by school, ability to favourite spells
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

- 2 frontends: DM interface (Desktop) and player interface (Phone)
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

- trenutno su sve mjerne jedinice postavljene u metrima i feet, a treba ih pretvorit u gridmap squares
- gridmap -> 1 square ≈ 2.5cm irl
- odredi koliko ce 1 square bit u feet. prodi kroz spellove u Player's Handbook-u, statuseffecte u StatusEffect.java i guglaj sta su drugi napravili
- koliki ce bit (u squares): PC movement range, spell range, improvised throw weapon range, 2 ranged weapon ranges (shorter one with disadvantage)
- gridmap aoe spells (nacrtat aoe grid za svaki radius, pregledat sve spellove za cudne oblike npr. cone i nacrtat kak ce to izgledat za razlicite rangeve)
- gridmap Wall of Fire ?
- kako funkcioniraju hit dice (short rest, long rest, levelup)
- koji ability za attack roll a koji za damage roll (napisi listu po klasama i tipovima oruzja ak treba nemam pojma)
- weapon types and scaling (finesse, versatile, martial...) https://bg3.wiki/wiki/Weapons#Properties
- nauci kak funkcionira git i github (zato da mi mozes contributat u kod bez mog inputa):
    - commands (add, commit, pull, push, branch, merge, pull request)
    - Feature branching Git workflow
- popunit subclasses u kodu na githubu (GameClass.java)
- promjeni spell upcastove u true na lv1 spellovima gdje treba
- if any spell mentions distance in meters (ex. 9 m): find description and convert to ft
- dodavat spellove koji fale u json-u i pregledat ove bg3 spellove koji su tu jel su isti efekti i ako nisu odabrat koji se cini bolji
- povezat spellove i status effecte u kodu
- dodavanje slika spellovima
- convertat feet u squares svugdje u kodu

RULES:

[google drive download link for all 3:](https://drive.google.com/drive/folders/1fJvKEWDJ7MjdcF3NVsntdT7wIlEm06JC?usp=sharing)
- DnD 5e Players Handbook
- D&D 5e Dungeon Master's Guide
- 5th Edition - Essentials Kit Rulebook
















